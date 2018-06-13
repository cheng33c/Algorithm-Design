#include <iostream>
using namespace std;

int count = 0;
void move(int n, char a, char b);
void hanoi(int n, char a, char b, char c) {
    if (n == 1)
        move(n, a, c);
    else {
        hanoi(n-1, a, c, b);
        move(n, a, c);
        hanoi(n-1, b, a, c);
    }
}

void move(int n, char a, char b) {
    cout << ++count << ": " << n << " " << a << " " << b << endl;
}

int main() {
    int N;
    cin >> N;

    hanoi(N, 'A', 'B', 'C');

    return 0;
}
