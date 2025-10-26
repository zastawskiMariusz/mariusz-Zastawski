#include <stdio.h>


int main() {
    int x1, y1, x2, y2;
    int szerokosc, wysokosc;
    int pole, obwod;

    printf("Podaj wspolrzedne pierwszego wierzcholka (x1 y1): ");
    scanf("%d %d", &x1, &y1);

    printf("Podaj wspolrzedne przeciwleglego wierzcholka (x2 y2): ");
    scanf("%d %d", &x2, &y2);

    szerokosc = x2 - x1;
    wysokosc = y2 - y1;

    
    pole = szerokosc * wysokosc;
    obwod = 2 * (szerokosc + wysokosc);

    printf("Pole prostokata: %d\n", pole);
    printf("Obwod prostokata: %d\n", obwod);

    return 0;
}
