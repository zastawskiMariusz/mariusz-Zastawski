#include <stdio.h>

void wypisz(int n) {
    if(n>0){
    wypisz(n - 1);
    printf("%d ", n);
}
}
int main() {
    int n = 5;
    printf("%d", n);
    wypisz(n);
  
}
