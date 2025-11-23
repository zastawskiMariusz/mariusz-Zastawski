#include <stdio.h>

int main() {
    int a, b;

    printf("Podaj liczbę a: ");
    scanf("%d", &a);
    printf("Podaj liczbę b: ");
    scanf("%d", &b);

    int c = 1; 
    int wynik = a; 

    while (wynik <= b) {
        c++;
        wynik *= a; 
    }

    printf("Pierwsza liczba c, taka że %d do potęgi c jest większe od %d to: %d\n", a, b, c);

    return 0;
}
