#include <stdio.h>
#include <ctype.h>

int tablica[20];

void wypisz(int n) {
    if (n == 0) {
        printf("Blad: Tablica jest pusta!\n");
    } else {
        printf("Elementy tablicy: ");
        for (int i = 0; i < n; i++) {
            printf("%d ", tablica[i]);
        }
        printf("\n");
    }
}

int suma_elementow(int n) {
    if (n == 0) return -1; 
    int s = 0;
    for (int i = 0; i < n; i++) {
        s += tablica[i];
    }
    return s;
}

int main() {
    int n = 0; 
    char wybor, znak;
    int liczba, i, j;

    
    while (1) {
        printf("\nWybierz opcje (e-koniec, w-wypisz, d-dodaj znak, D-dodaj liczbe, u-usun, s-suma): ");
        scanf(" %c", &wybor); 

        switch (wybor) {
            case 'e':
                return 0; 

            case 'w':
                wypisz(n);
                break;

            case 'd':
                if (n < 20) {
                    printf("Podaj znak (char): ");
                    scanf(" %c", &znak);
                    if (isdigit(znak)) {
                        tablica[n] = znak - '0'; 
                    } else {
                        tablica[n] = (int)znak; 
                    }
                    n++;
                } else {
                    printf("Brak miejsca w tablicy!\n");
                }
                break;

            case 'D':
                if (n < 20) {
                    printf("Podaj liczbe: ");
                    scanf("%d", &liczba);
                    tablica[n] = liczba;
                    n++;
                } else {
                    printf("Brak miejsca w tablicy!\n");
                }
                break;

            case 'u':
                printf("Podaj liczbe do usuniecia: ");
                scanf("%d", &liczba);
                for (i = 0; i < n; i++) {
                    if (tablica[i] == liczba) {
                        
                        for (j = i; j < n - 1; j++) {
                            tablica[j] = tablica[j + 1];
                        }
                        n--; 
                        i--; 
                    }
                }
                break;

            case 's':
                {
                    int wynik = suma_elementow(n);
                    if (wynik == -1) {
                        printf("Komunikat: Tablica pusta, nie mozna policzyc sumy.\n");
                    } else {
                        printf("Suma: %d\n", wynik);
                    }
                }
                break;

            default:
                printf("Nieznana opcja!\n");
        }
    }

    return 0;
}