/********************************************************************************************************
 
 **Copywrite:	shenqike.com^-^
 **Author:		amazingguo
 **Description:	POJ 1001 Problems involving the computation of exact values of very large magnitude and precision are common. For example, the computation of the national debt is a taxing experience for many computer systems.
 **				This problem requires that you write a program to compute the exact value of Rn where R is a real number ( 0.0 < R < 99.999 ) and n is an integer such that 0 < n <= 25.
 **Tips:			After finishing a small code block,make sure it's working by testing it,
 **				don't hurry to write them at once and at total loss about what you have just done.
 **Date:			2013-03-28 11:00 ~ 2012-04-04 17:21
 **Result:		worked pretty well for decimal and integer except one special case:when the base is 10,
 **				the exponent is, let's say 2
 **				the programme is not able to decide the effective number of the result, it just print 1,
 **				needs refining, it's unknown that whether this is the reason of "Wrong Answer"
 **Date:			2013-04-04 19:00
 **				the "base 10 Problem" solved, but the answer is not accepted still...
 **Date:			2013-11-17
 **				1.0000 2 gives a wrong result 1. and this problem is perfectly solved then the code is Accepted!
 *********************************************************************************************************/
#include <stdio.h>
#include <string.h>
#define BASE_NUM 7			/*指定基数数组的大小，输入六位，但注意到字符串最后一位一定是'\0'*/
#define FINAL_NUM 200		/*指定结果数组的大小，6*25=150，用200位足够*/

void Convert_Find(char *, int *);
void Exponent_Multiply(char *, char *, int);
void Copy_Str(char *,	char *);
void Trim_Print(char *, int, int, int);

int main(void)
{
    char base[BASE_NUM] = { 0 },
    final_result[FINAL_NUM] = { 0 };							/*基数，中间变量，结果*/
    int exponent =  0,
    decimal_num = BASE_NUM;										/*指数，小数位(初始化为BASE_NUM)*/
    int i;
    int flag_for_10 = 0;
    /*the main loop*/
    while (scanf("%s %d", base, &exponent) == 2)					/*The input should be in pairs*/
    {
        if (base[strlen(base) - 1] == '0')
            flag_for_10 = 1;
        Convert_Find(base, &decimal_num);
        Copy_Str(final_result, base);								/*将base拷贝到final_result最后7位 strcpy stops work if the base contains 0 in it,write one myself*/
        Exponent_Multiply(base, final_result, (exponent - 1));		/*exponent - 1 as final_result == base*/
        Trim_Print(final_result, exponent, decimal_num, flag_for_10);
        for(i = BASE_NUM - 1; i >= 0; i--)
            base[i] = 0;
        decimal_num = BASE_NUM;										/*every time predefine decimal to 7*/
        flag_for_10 = 0;
    }
    return 0;
}

/*
 **将输入的字符型转换为数字：'1'转换为1，etc，小数点前数字移位消掉小数点，求得小数位数
 **基数base既是输入又是输出，num是输出
 */
void Convert_Find(char *base, int *num)
{
    int i = 0, A_a = '0';
    
    /*将输入的字符型转换为数字：'1'转换为1，etc*/
    while (i < BASE_NUM - 1)
    {
        /*if the input is 12, you have '1','2','\0','\0','\0','\0','\0' in you storage, try to avoid the 0 is subtracted*/
        if(*(base + i) != 0)
        {
            *(base + i) -= A_a;
            if(*(base + i) < 0)
            {
                *num = BASE_NUM - i - 2;		/*if base[2] == '.' then decimal_num = 3*/
            }
        }
        i++;
    }
    
    /*小数点前数字移位消掉小数点*/
    if(*num < BASE_NUM)							/*test if the decimal_num has been changed*/
    {
        i = BASE_NUM - (*num) - 1;
        while (--i > 0)
            *(base + i) = *(base + i - 1);
        *base = 0;
    }
    
}

/*
 **计算幂函数的值
 **输入为基数base，指数expo，final既是输入又是输出
 */
void Exponent_Multiply(char *base, char *final, int expo)
{
    char middle_result[BASE_NUM][FINAL_NUM] = { 0 };						/*ervrytime new an array to hold the middle result*/
    int i, j;
    while (expo--)
    {
        for (i = BASE_NUM - 1; i >= 0; i--)									/*clear middle_result*/
            for(j = FINAL_NUM - 1; j >= 0; j--)
            {
                middle_result[i][j] = 0;
            }
        for (i = BASE_NUM - 1; i >= 0; i--)
            for(j = FINAL_NUM - 1; j > BASE_NUM; j--)						/*to avoid j - (BASE_NUM - 1 - i) < 0*/
            {
                /*对应位相乘,要错位相加，所以j下标要减去 (BASE_NUM - i - 1)*/
                middle_result[i][j - (BASE_NUM - 1 - i)] += (base[i] * final[j]) % 10;
                middle_result[i][j - 1 - (BASE_NUM - 1 - i)] += (base[i] * final[j]) / 10;
                /*进位,要错位相加，所以j下标要减去 (BASE_NUM - i - 1)*/
                middle_result[i][j - 1 - (BASE_NUM - 1 - i)] += middle_result[i][j - (BASE_NUM - 1 - i)] / 10;
                middle_result[i][j - (BASE_NUM - 1 - i)] %= 10;
            }
        
        for (j = FINAL_NUM - 1; j >= 0; j--)								/*clear final*/
            final[j] = 0;
        /*add up middle_result colums and mode 10 separately*/
        for (j = FINAL_NUM - 1; j > 0; j--){								/*as you have 200 elements in a row, to avoid y < 0, it's ok to set y be more than one*/
            for (i = BASE_NUM - 1; i >= 0; i--)
                final[j] += middle_result[i][j];
            final[j - 1] += final[j] / 10;
            final[j] %= 10;
        }
    }
}
/*
 **copy src string to dst string
 **input : src; output : dst.
 */
void Copy_Str(char *dst, char *src)
{
    int i = BASE_NUM - 1;													/*base下标从BASE_NUM-1开始*/
    while (i >= 0)
    {
        dst[FINAL_NUM - BASE_NUM + i] = src[i];								/*copy ...*/
        i--;
    }
}
/*
 **Trim the zeros in the end and in the front
 **insert the dot in the right place if the base is a decimal
 **putchar the result
 */
void Trim_Print(char *final, int expo, int decimal, int flag)
{
    int start_point = 0, end_point = FINAL_NUM - 1;
    int i;
    /*note that in the result you have exponent useless trailing zeros*/
    if (decimal < BASE_NUM)												/*this is to say that the input is not an inteager*/
    {
        int dot_place_holder = expo + expo * decimal;
        /*add the '.'*/
        for (i = FINAL_NUM - 2; i >= FINAL_NUM - dot_place_holder; i--)		/*FINAL_NUM-2：后面的expo位都是零，所以不存在挤掉有效位的问题*/
            final[i + 1] = final[i];
        final[++i] = '.';
    }
    /*find the start and end digit of the output, note that the integer is different from the non integer*/
    while (*(final + start_point) == 0)
        start_point++;
    while (*(final + end_point) == 0)
        end_point--;
    if (*(final + end_point) == '.')
        end_point--;
    if (decimal == BASE_NUM && flag)									/*if the effective is bigger than the result, base must be 10*/
        end_point += expo;
    /*putchar the digit one by one*/
    for (i = start_point; i <= end_point; i++)
    {
        if(final[i] == '.')
            putchar(final[i]);
        else
            putchar(final[i] + '0');
    }
    putchar('\n');
    /*clear final*/
    for(i = FINAL_NUM - 1; i >= 0; i--)
        final[i] = 0;
}
