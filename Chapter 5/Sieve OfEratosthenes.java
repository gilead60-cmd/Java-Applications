boolean[] prime = new boolean[1000];

for (int i = 2; i < 1000; i++)
    prime[i] = true;

for (int i = 2; i < 1000; i++) {
    if (prime[i]) {
        for (int j = i + i; j < 1000; j += i)
            prime[j] = false;
    }
}
