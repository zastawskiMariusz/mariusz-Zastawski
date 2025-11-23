#include <stdio.h>

int main() {
    int wiersze, kolumny;
    
   
    printf("Podaj liczbę wierszy: ");
    scanf("%d", &wiersze);
    printf("Podaj liczbę kolumn: ");
    scanf("%d", &kolumny);
    
    int tablica[wiersze][kolumny];
    

    printf("Podaj zawartość tablicy (0 lub 1):\n");
    for (int i = 0; i < wiersze; i++) {
        for (int j = 0; j < kolumny; j++) {
            printf("Tablica[%d][%d] = ", i, j);
            scanf("%d", &tablica[i][j]);
        }
    }
    

    printf("|--|\n");

    
    for (int i = 0; i < wiersze; i++) {
        printf("|"); 

        
        for (int j = 0; j < kolumny; j++) {
            if (tablica[i][j] == 1) {
                printf("x");
            } else {
                printf(" ");
            }
        }

       
        printf("|\n");
    }

    printf("|--|\n");

    
    return 0;
}
