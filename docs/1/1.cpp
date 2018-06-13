#include <iostream>

using namespace std;
int q(int n, int m);
int main() {
    int N;
    cin >> N;
    cout << q(N, N);

    return 0;
}

int q(int n, int m) {

    if (n < 1 || m < 1) return 0;
    if (n == 1 || m == 1) return 1;
    if (n < m) return q(n, n);
    if (n == m) return q(n, m - 1) + 1;
    return q(n, m - 1) + q(n - m, m);
}
