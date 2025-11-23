#include <stdio.h>

int main() {
    int n;
    
  
    printf("Podaj liczby w tablicy (rozmiar n): ");
    scanf("%d", &n);
    
    int tablica[n];  
    int kwadraty[n]; 
    
    printf("Podaj %d liczb:\n", n);
    for (int i = 0; i < n; i++) {
        printf("Liczba %d: ", i + 1);
        scanf("%d", &tablica[i]);
    }
  
    for (int i = 0; i < n; i++) {
        kwadraty[i] = tablica[i];
    }
    
    
    printf("Tablica kwadratów:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", kwadraty[i]);
    }
    printf("\n");
    
    return 0;
}
