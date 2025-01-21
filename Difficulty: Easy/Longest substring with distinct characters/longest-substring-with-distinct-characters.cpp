//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
  int longestUniqueSubstr(string &s) {
    int lastSeen[26];                     
    fill(lastSeen, lastSeen + 26, -1);    

    int maxLength = 0;                    
    int i = 0;                            

    for (int j = 0; j < s.size(); j++) {
        int charIndex = s[j] - 'a';       

        if (lastSeen[charIndex] != -1) {
            i = max(i, lastSeen[charIndex] + 1); 
        }

        lastSeen[charIndex] = j;

        maxLength = max(maxLength, j - i + 1);
    }

    return maxLength;
}
};




//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {

        Solution obj;
        string s;
        cin >> s;
        cout << obj.longestUniqueSubstr(s) << endl;
        cout << "~"
             << "\n";
    }

    return 0;
}

// } Driver Code Ends