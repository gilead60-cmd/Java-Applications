# Restaurant Static Ordering Demo

This is a simple static demo for a restaurant menu and ordering flow.

Features:
- Menu list with prices
- Add multiple items with quantities
- Cart with modify/remove controls
- Checkout form that asks for customer details and payment method (card or cash)
- "Call restaurant" link
- Orders are stored in localStorage (demo-only)

How to run:
- Open `index.html` in your browser directly, or run a simple local server:

  # PowerShell
  python -m http.server 8000; Start-Process http://localhost:8000

Notes:
- This is frontend-only. For production you'll need a backend to accept and process orders and a real payment provider for card payments.
- Next steps: integrate backend API, add validations, and integrate a payment gateway like Stripe or PayPal.
