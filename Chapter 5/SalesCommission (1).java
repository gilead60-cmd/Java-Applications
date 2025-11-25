int[] ranges = new int[9];

Scanner input = new Scanner(System.in);

while (input.hasNext()) {
    double sales = input.nextDouble();
    int salary = (int) (200 + 0.09 * sales);

    int index;
    if (salary >= 1000)
        index = 8;
    else
        index = (salary - 200) / 100;

    ranges[index]++;
}
