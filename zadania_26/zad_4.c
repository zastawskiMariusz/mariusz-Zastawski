#include <stdio.h>

int main() {
    int a;
    int b;
    int c;

    printf("Podaj pierwsza liczbe a: ");
    scanf("%i", &a);

    printf("Podaj liczbe b: ");
    scanf("%i", &b);

    printf("Podaj trzecia liczbe c: ");
    scanf("%i", &c); 

    if (a > b && a > c) {
        printf("Liczba a jest największa: %i\n", a);
    } else if (b > a && b > c) {
        printf("Liczba b jest największa: %i\n", b);
    } else {
        printf("Liczba c jest największa: %i\n", c);
    }

    return 0;
}
