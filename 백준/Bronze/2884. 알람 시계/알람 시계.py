
import sys
input = sys.stdin.readline
# 첫 줄에는 정수 x가 주어진다. (−1000 ≤ x ≤ 1000; x ≠ 0) 다음 줄에는 정수 y가 주어진다. (−1000 ≤ y ≤ 1000; y ≠ 0)


def main():
    H, M = map(int, input().split())
    if M - 45 >= 0:
        print(H, M - 45)
    else:
        H -= 1
        M -= 45
        if H < 0:
            print((24+H), (60+M))
        else:
            print(H, (60+M))


if __name__ == "__main__":
    main()
