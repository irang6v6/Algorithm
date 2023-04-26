
import sys
input = sys.stdin.readline
# 첫 줄에는 정수 x가 주어진다. (−1000 ≤ x ≤ 1000; x ≠ 0) 다음 줄에는 정수 y가 주어진다. (−1000 ≤ y ≤ 1000; y ≠ 0)


def main():
    x = int(input())
    y = int(input())

    if x > 0 and y > 0:
        print("1")
    elif x > 0 and y < 0:
        print("4")
    elif x < 0 and y > 0:
        print("2")
    else :
        print("3")


if __name__ == "__main__":
    main()
