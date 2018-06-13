#include <iostream>
using namespace std;

void perm(int *list, int k, int m);
int list[1000];
int main() {
    int N;
    cin >> N;
    for (int i = 0; i < N; ++i)
        cin >> list[i];
    perm(list, 0, N-1);

    return 0;
}

void perm(int *list, int k, int m) {
    if (k == m) {
        for (int i = 0; i <= m; ++i)
            cout << list[i];
        cout << endl;
    } else {
        for (int i = k; i <= m; ++i) {
            swap(list[i], list[k]);
            perm(list, k+1, m);
            swap(list[i], list[k]);
        }
    }
}
