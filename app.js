const menu = [
  { id: 1, name: 'Margherita Pizza', price: 9.99 },
  { id: 2, name: 'Pepperoni Pizza', price: 11.99 },
  { id: 3, name: 'Veggie Burger', price: 8.5 },
  { id: 4, name: 'Grilled Chicken Salad', price: 10.0 },
  { id: 5, name: 'Spaghetti Bolognese', price: 12.0 },
  { id: 6, name: 'Fish & Chips', price: 13.5 },
];

const state = {
  cart: JSON.parse(localStorage.getItem('cart') || '[]')
};

function format(n){return n.toFixed(2)}

function renderMenu(){
  const menuList = document.getElementById('menu-list');
  menuList.innerHTML = '';
  menu.forEach(item => {
    const card = document.createElement('div');
    card.className = 'menu-item';
    card.innerHTML = `
      <h3>${item.name}</h3>
      <div class="price">$${format(item.price)}</div>
      <div class="meta">
        <div>
          <label>Qty <input type="number" min="1" value="1" data-id="${item.id}" class="qty" style="width:60px;margin-left:6px"/></label>
        </div>
        <button data-id="${item.id}">Add</button>
      </div>
    `;
    menuList.appendChild(card);
  });
}

function save(){
  localStorage.setItem('cart', JSON.stringify(state.cart));
}

function addToCart(id, qty=1){
  const item = menu.find(m=>m.id===id);
  if(!item) return;
  const existing = state.cart.find(c=>c.id===id);
  if(existing){ existing.qty += qty; }
  else{ state.cart.push({ id:item.id, name:item.name, price:item.price, qty }); }
  save();
  renderCart();
}

function removeFromCart(id){
  state.cart = state.cart.filter(c=>c.id!==id);
  save();
  renderCart();
}

function changeQty(id, qty){
  const it = state.cart.find(c=>c.id===id);
  if(!it) return;
  it.qty = qty;
  if(it.qty<=0) removeFromCart(id);
  else{ save(); renderCart(); }
}

function renderCart(){
  const container = document.getElementById('cart-items');
  container.innerHTML = '';
  let total = 0;
  state.cart.forEach(it=>{
    total += it.price*it.qty;
    const row = document.createElement('div');
    row.className = 'cart-row';
    row.innerHTML = `
      <div>
        <div>${it.name}</div>
        <div class="small">$${format(it.price)} each</div>
      </div>
      <div class="cart-controls">
        <button data-action="decrease" data-id="${it.id}">-</button>
        <span>${it.qty}</span>
        <button data-action="increase" data-id="${it.id}">+</button>
        <button data-action="remove" data-id="${it.id}">Remove</button>
      </div>
    `;
    container.appendChild(row);
  });
  document.getElementById('total').textContent = format(total);
}

// event wiring
function setup(){
  renderMenu();
  renderCart();

  document.getElementById('menu-list').addEventListener('click', e=>{
    if(e.target.tagName === 'BUTTON'){
      const id = Number(e.target.dataset.id);
      const qtyInput = e.target.closest('.menu-item').querySelector('.qty');
      const qty = Number(qtyInput.value) || 1;
      addToCart(id, qty);
    }
  });

  document.getElementById('cart-items').addEventListener('click', e=>{
    const action = e.target.dataset.action;
    const id = Number(e.target.dataset.id);
    if(!action) return;
    const item = state.cart.find(c=>c.id===id);
    if(!item) return;
    if(action==='decrease') changeQty(id, item.qty-1);
    if(action==='increase') changeQty(id, item.qty+1);
    if(action==='remove') removeFromCart(id);
  });

  // checkout
  const checkoutBtn = document.getElementById('checkout-btn');
  const modal = document.getElementById('checkout-modal');
  const cancelBtn = document.getElementById('cancel-btn');
  const form = document.getElementById('checkout-form');
  const cardFields = document.getElementById('card-fields');

  checkoutBtn.addEventListener('click', ()=>{
    if(state.cart.length===0){ alert('Add items to cart first'); return; }
    modal.classList.remove('hidden');
  });
  cancelBtn.addEventListener('click', ()=> modal.classList.add('hidden'));

  form.payment?.forEach(radio=> radio.addEventListener('change', ()=>{
    cardFields.style.display = form.payment.value === 'card' ? 'block' : 'none';
  }));

  form.addEventListener('submit', e=>{
    e.preventDefault();
    const data = new FormData(form);
    const order = {
      id: Date.now(),
      customer: data.get('name'),
      phone: data.get('phone'),
      address: data.get('address'),
      payment: data.get('payment'),
      items: state.cart,
      total: Number(document.getElementById('total').textContent)
    };
    // pretend to send to server
    console.log('Order', order);
    localStorage.setItem('lastOrder', JSON.stringify(order));
    state.cart = [];
    save();
    renderCart();
    modal.classList.add('hidden');
    showConfirmation(order);
  });

  document.getElementById('new-order').addEventListener('click', ()=>{
    document.getElementById('order-confirm').classList.add('hidden');
  });
}

function showConfirmation(order){
  const el = document.getElementById('order-confirm');
  const summary = document.getElementById('order-summary');
  summary.innerHTML = `
    <p>Thanks, ${order.customer}! Your order (#${order.id}) is placed.</p>
    <p>Total: $${format(order.total)}</p>
    <p>Payment: ${order.payment}</p>
    <h4>Items</h4>
    <ul>${order.items.map(i=>`<li>${i.qty} × ${i.name} — $${format(i.price*i.qty)}</li>`).join('')}</ul>
    <p>We may call you at ${order.phone} if needed.</p>
  `;
  el.classList.remove('hidden');
}

window.addEventListener('DOMContentLoaded', setup);