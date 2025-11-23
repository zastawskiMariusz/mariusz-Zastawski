#include <stdio.h>

int suma_kwadratow(int n) {
    int suma = 0;
    for (int i = 1; i <= n; i++) {
        suma += i * i;
    }
    return suma;
}

int main() {
    int n;
    printf("Podaj liczbę naturalną n: ");
    scanf("%d", &n);

    printf("Suma kwadratów liczb od 1 do %d to: %d\n", n, suma_kwadratow(n));

    return 0;
}
