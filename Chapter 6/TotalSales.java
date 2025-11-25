int[][] sales = new int[5][4];

// reading slips
int person = input.nextInt();
int product = input.nextInt();
int value = input.nextInt();

sales[product-1][person-1] += value;
