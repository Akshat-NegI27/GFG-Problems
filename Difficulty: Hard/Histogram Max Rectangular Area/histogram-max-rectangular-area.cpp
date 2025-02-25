//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
public:
    int getMaxArea(vector<int> &arr) {
        stack<int> s;
        int max_area = 0;
        int tp;
        int area_with_top;
        int i = 0;

        while (i < arr.size()) {
            if (s.empty() || arr[s.top()] <= arr[i]) {
                s.push(i++);
            } else {
                tp = s.top();
                s.pop();
                area_with_top = arr[tp] * (s.empty() ? i : i - s.top() - 1);
                max_area = max(max_area, area_with_top);
            }
        }

        while (!s.empty()) {
            tp = s.top();
            s.pop();
            area_with_top = arr[tp] * (s.empty() ? i : i - s.top() - 1);
            max_area = max(max_area, area_with_top);
        }

        return max_area;
    }
};



//{ Driver Code Starts.

int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        Solution obj;
        int res = obj.getMaxArea(arr);
        cout << res << endl;
        cout << "~" << endl;
        // string tl;
        // getline(cin, tl);
    }
    return 0;
}

// } Driver Code Ends