#include <stdio.h>

int main() {
    int a, b;

    printf("Podaj pierwsza liczbe: ");
    scanf("%d", &a);

    printf("Podaj druga liczbe: ");
    scanf("%d", &b);

    

    if (a>b) {
        printf("liczba a jest większa %d\n ", a);

    } else {
        printf("liczba b jest większa %d\n", b);
    }

    return 0;
}