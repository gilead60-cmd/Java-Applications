public static int product(int... values) {
    int result = 1;
    for (int v : values)
        result *= v;
    return result;
}
