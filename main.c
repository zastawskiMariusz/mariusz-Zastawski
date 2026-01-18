#include <stdio.h>

int n = 0;   /* globalna liczba elementów */

void wypisz(char tab[]) {
    if (n == 0) {
        printf("Blad: tablica jest pusta\n");
        return;
    }
    for (int i = 0; i < n; i++) {
        printf("%c ", tab[i]);
    }
    printf("\n");
}

void dodaj(char tab[]) {
    char c;

    if (n >= 100) {
        printf("Blad: brak miejsca w tablicy\n");
        return;
    }

    printf("Podaj cyfre: ");
    scanf(" %c", &c);

    if (c < '0' || c > '9') {
        printf("Blad: to nie jest cyfra\n");
        return;
    }

    tab[n] = c;
    n++;
}

void usun(char tab[]) {
    int idx;

    if (n == 0) {
        printf("Blad: tablica jest pusta\n");
        return;
    }

    printf("Podaj indeks: ");
    scanf("%d", &idx);

    if (idx < 0 || idx >= n) {
        printf("Blad: niepoprawny indeks\n");
        return;
    }

    for (int i = idx; i < n - 1; i++) {
        tab[i] = tab[i + 1];
    }
    n--;
}

int suma(char tab[]) {
    if (n == 0) return -1;

    int s = 0;
    for (int i = 0; i < n; i++) {
        s += tab[i] - '0';
    }
    return s;
}

void drzewo(char tab[]) {
    if (n == 0) {
        printf("Blad: tablica jest pusta\n");
        return;
    }

    int i = 0;
    int poziom = 1;

    while (i < n) {
        for (int sp = 0; sp < n - poziom; sp++)
            printf(" ");

        for (int j = 0; j < poziom && i < n; j++) {
            printf("%c ", tab[i]);
            i++;
        }
        printf("\n");
        poziom *= 2;
    }
}

int main() {
    char tab[100];
    int wybor;

    while (1) {
        printf("\n0 - wyjscie\n");
        printf("1 - wypisz tablice\n");
        printf("2 - dodaj cyfre\n");
        printf("3 - usun element\n");
        printf("4 - suma cyfr\n");
        printf("5 - drzewo binarne\n");
        printf("Wybor: ");

        scanf("%d", &wybor);

        switch (wybor) {
            case 0:
                return 0;
            case 1:
                wypisz(tab);
                break;
            case 2:
                dodaj(tab);
                break;
            case 3:
                usun(tab);
                break;
            case 4: {
                int s = suma(tab);
                if (s == -1)
                    printf("Blad: tablica jest pusta\n");
                else
                    printf("Suma = %d\n", s);
                break;
            }
            case 5:
                drzewo(tab);
                break;
            default:
                printf("Bladny wybor\n");
        }
    }
}
