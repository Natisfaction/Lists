#include <stdio.h>
#include "List.h"

int main(){
    List l1;
    
    initializeList(&l1);

    int x = 7;
    int c = 5;

    addElement(&l1, &c);
    addElement(&l1, &x);

    printList(&l1);

    return 0;
}