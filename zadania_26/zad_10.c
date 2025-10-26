#include <stdio.h>

int main() {
    double a, b, c;


    printf("Podaj dlugosci trzech odcinkow: ");
    scanf("%lf %lf %lf", &a, &b, &c);


    if (a + b > c && a + c > b && b + c > a) {
        printf("Mozna utworzyc trojkat z tych odcinkow.\n");
    } else {
        printf("Nie mozna utworzyc trojkata z tych odcinkow.\n");
    }

    return 0;
}
