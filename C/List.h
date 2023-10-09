#include <stdio.h>
#include <stdlib.h>

#ifndef LIST_H
#define LIST_H

typedef struct List{
    void* element;
    int index;
    struct List* sublist;
} List;

int initializeList(List* list);
void addElement(List* list, void* element);
void printList(List* list);

#endif