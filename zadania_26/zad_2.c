#include <stdio.h>

int main() {
    int a, b;

    printf("Podaj pierwsza liczbe: ");
    scanf("%d", &a);

    printf("Podaj druga liczbe: ");
    scanf("%d", &b);

    printf("Dodawanie: %d\n", a + b);
    printf("Odejmowanie: %d\n", a - b);
    printf("Mnozenie: %d\n", a * b);

    if (b != 0) {
        printf("Dzielenie: %d\n", a / b);
        printf("Reszta z dzielenia: %d\n", a % b);
    } else {
        printf("Nie mozna dzielic przez zero!\n");
    }

    return 0;
}