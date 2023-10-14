#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#ifndef LIST_H
#define LIST_H

#define INT_ELEMENT     0
#define CHAR_ELEMENT    1
#define FLOAT_ELEMENT   2

#define DOUBLE_ELEMENT  3
#define STRING_ELEMENT  4
#define RAW_ELEMENT     9

/*  TYPES OF ELEMENTS  *
 *  0   --->    int    *
 *  1   --->    char   *
 *  2   --->    float  *
 *  3   --->    double *
 *  4   --->    String *
 *  9   --->    RAW    */

typedef struct List{
    void* element;              // Element
    int index;                  // Element's index
    int type;                   // Element's type

    struct List* sublist;       // Sublist
} List;

int initializeList(List* list);
void printList(List* list);
void setType(List* list, int type);

void addElement(List* list, void* element);
void addInt(List* list, int* element);
void addChar(List* list, char element);

void addFloat(List* list, float element);
void addDouble(List* list, double element);
void addString(List* list, char* element);

#endif