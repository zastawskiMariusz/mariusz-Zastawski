#include <stdio.h>

int main() {
    int dzien, miesiac, rok;
    int poprawna = 1; 

    printf("Podaj dzien: ");
    scanf("%d", &dzien);

    printf("Podaj miesiac: ");
    scanf("%d", &miesiac);

    printf("Podaj rok: ");
    scanf("%d", &rok);


    if (rok < 1) {
        printf("Zła liczba roku.\n");
        poprawna = 0;
    } else if (miesiac < 1 || miesiac > 12) {
        printf("Zła liczba miesiąca.\n");
        poprawna = 0;
    } else if (dzien < 1 || dzien > 31) {
        printf("Zły dzień miesiąca.\n");
        poprawna = 0;
    }

    if (poprawna)
        printf("Data %d.%d.%d jest poprawna.\n", dzien, miesiac, rok);
    else
        printf("Data %d.%d.%d jest NIEpoprawna.\n", dzien, miesiac, rok);

    return 0;
}
