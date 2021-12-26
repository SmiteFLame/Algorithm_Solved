a1="IJKLABCDEFGH"
a2=[6,7,8,9,0,1,2,3,4,5]
n=int(input())
print(str(a1[n%60%12])+str(a2[n%60%10]))
