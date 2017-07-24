/* Computes the dimention weight of a box from input provided by the user */

#include <stdio.h>

#define CUBIC_IN_PER_LB 166

int main() {
	int height, length, width, volume, weight;

	printf("Enter height of box: ");
	scanf("%d", &height);
	printf("Enter length of box: ");
	scanf("%d", &length);
	printf("Enter width of box: ");
	scanf("%d", &width);

	volume = height * length * width;

	/* Example macro definition using define preprocessor directive */
	weight = (volume + CUBIC_IN_PER_LB - 1) / CUBIC_IN_PER_LB;

	printf("Volume (cubic inches): %d\n", volume);
	printf("Dimensional weight (pounds): %d\n", weight);

	return 0;
}
