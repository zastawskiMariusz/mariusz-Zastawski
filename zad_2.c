#include <stdio.h>

int main() {
    int a, b;


    printf("Podaj liczbę a: ");
    scanf("%d", &a);
    printf("Podaj liczbę b (wykładnik potęgi): ");
    scanf("%d", &b);

    int wynik = 1;


    for (int i = 1; i <= b; i++) {
        wynik *= a;
    }

  
    printf("%d do potęgi %d to: %d\n", a, b, wynik);

    return 0;
}
