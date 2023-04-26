
import sys
input = sys.stdin.readline
# 윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.


def main():
    score = int(input())
    if score % 4 == 0 and (score % 100 != 0 or score % 400 == 0):
        print("1")
    else:
        print("0")


if __name__ == "__main__":
    main()
