#include <stdio.h>

int silnia(int n) {
    if (n > 0 )
        return n * silnia(n - 1);
    else
        
        return 1;
}

int main() {
    int n =5;
    printf("%d\n", silnia(n));
    return 0;
}
