
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

bool checkVowel(int charIntValue)
{
  bool check = charIntValue == 0 || charIntValue == 4 || charIntValue == 8 || charIntValue == 14 || charIntValue == 20;
  return check;
}
int getCharInt(char c)
{
  int charIntValue = (int)(c) - 97;
  return charIntValue;
}
void changeParams(int *vowels, int *consonants, int *tempBuffer, int charIntValue)
{
  if (checkVowel(charIntValue))
  {
    *vowels += 1;
  }
  else
  {
    *consonants += 1;
  }

  int temp = *((tempBuffer + 0) + charIntValue);
  temp += 1;
  *((tempBuffer + 0) + charIntValue) = temp;
  return;
}
void printMultiArray(int arr[][25])
{
  for (int i = 0; i < 2; i++)
  {
    for (int j = 0; j < 25; j++)
    {
      printf("%d\t", arr[i][j]);
    }
    printf("\n");
  }
  return;
}
int main(void)
{
  int t;
  scanf("%d", &t);
  while (t > 0)
  {
    int alice[2][25] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int bob[2][25] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int l;
    int n=0,m=0;
    scanf("%d", &l);

    for (int k = 0; k < l; k++)
    {
      int temp[2][25];
      memset(temp, 0, sizeof(temp[0][0]) * 2 * 25);
      int tempBuffer[2][25];
      memcpy(tempBuffer, temp, sizeof temp);
      int vowels = 0;
      int consonants = 0;
      bool checkType = true;
      char inputStr[10001];
      scanf("%s", inputStr);
      int len = strlen(inputStr);
      int cIntValue = getCharInt(inputStr[0]);
      changeParams(&vowels, &consonants, &tempBuffer[0][0], cIntValue);
      tempBuffer[1][cIntValue] = 1;
      for (int j = 1; j < len; j++)
      {
        int charIntValue = getCharInt(inputStr[j]);
        // printf("%d %d\n", charIntValue, inputStr[j]);
        changeParams(&vowels, &consonants, &tempBuffer[0][0], charIntValue);
        tempBuffer[1][charIntValue] = 1;
        checkType = checkType && vowels >= consonants;
      }
      if(checkType){
            n=n+1;
        } else{
            m=m+1;
        }
        // printf("n=%d \t m=%d \n",n,m);
        // printf("\n");
    //   printMultiArray(tempBuffer);
    //   printf("\n");
        for (int j = 0; j < 25; j++)
        {
          if (checkType)
          {
            alice[0][j] += tempBuffer[0][j];
            alice[1][j] += tempBuffer[1][j];
          }
          else
          {
            bob[0][j] += tempBuffer[0][j];
            bob[1][j] += tempBuffer[1][j];
          }
        }
    //   printMultiArray(alice);
    //   printf("\n");
        // printMultiArray(bob);
        // printf("\n");
    }
    long num=1;
    long den = 1;
    double temp=1;
    bool flag=0;
    // printf("bobDen=\n");
    for (int i = 0; i < 25; i++)
    {
      if (alice[0][i] != 0 && alice[1][i] != 0)
      {
        num = alice[1][i];
        den = pow(alice[0][i], n);
        temp=temp*num/den;
      }
      if (bob[0][i] != 0 && bob[1][i] != 0)
      {
        den = bob[1][i];
        num = pow(bob[0][i], m);
        
        // printf("%d,%d\t", num,bob[0][i]);
        temp=temp*num/den;
        
      }
      if(temp>10e7){
            flag=1;
            break;
        }
    }
    if(flag==0){
        
    // printf("\n(%d)/ (%d)\n", num,den);
    float score = temp*1.0;
    printf("%0.7f\n", score);
    }
    else{
        printf("Infinity\n");
    }
    t--;
  }

  return 0;
}
