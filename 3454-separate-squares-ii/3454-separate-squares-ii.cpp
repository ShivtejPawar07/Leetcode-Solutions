#include <vector>
#include <algorithm>
#include <set>
#include <iomanip>

using namespace std;

class Solution {
    struct Event {
        int y, x1, x2, type;
        bool operator<(const Event& other) const {
            if (y != other.y) return y < other.y;
            return type > other.type;
        }
    };

    struct Node {
        int count = 0;
        long long length = 0;
    };

    vector<Node> tree;
    vector<int> coords;

    void update(int node, int start, int end, int l, int r, int val) {
        if (coords[end + 1] <= l || coords[start] >= r) return;
        if (l <= coords[start] && coords[end + 1] <= r) {
            tree[node].count += val;
        } else {
            int mid = start + (end - start) / 2;
            update(2 * node, start, mid, l, r, val);
            update(2 * node + 1, mid + 1, end, l, r, val);
        }

        if (tree[node].count > 0) {
            tree[node].length = coords[end + 1] - coords[start];
        } else if (start != end) {
            tree[node].length = tree[2 * node].length + tree[2 * node + 1].length;
        } else {
            tree[node].length = 0;
        }
    }

public:
    double separateSquares(vector<vector<int>>& squares) {
        vector<Event> events;
        set<int> x_set;
        for (auto& s : squares) {
            int x = s[0], y = s[1], l = s[2];
            events.push_back({y, x, x + l, 1});
            events.push_back({y + l, x, x + l, -1});
            x_set.insert(x);
            x_set.insert(x + l);
        }
        sort(events.begin(), events.end());
        coords.assign(x_set.begin(), x_set.end());

        int n = coords.size();
        tree.assign(4 * n, {0, 0});

        // 1. प्रत्येक Y-interval मध्ये किती 'Union Width' आहे ते प्री-कॅल्क्युलेट करा
        vector<pair<double, double>> intervals; // {y_diff, width_at_that_time}
        double totalArea = 0;

        for (int i = 0; i < (int)events.size() - 1; ++i) {
            update(1, 0, n - 2, events[i].x1, events[i].x2, events[i].type);
            double dy = events[i+1].y - events[i].y;
            double currentWidth = tree[1].length;
            if (dy > 0) {
                intervals.push_back({(double)events[i].y, currentWidth});
                totalArea += dy * currentWidth;
            }
        }

        // 2. Binary Search on Y
        double target = totalArea / 2.0;
        double low = events.front().y, high = events.back().y;

        for (int i = 0; i < 60; ++i) {
            double mid = (low + high) / 2.0;
            double currentArea = 0;
            
            // हा भाग वेगाने क्षेत्रफळ मोजतो
            for (int j = 0; j < (int)events.size() - 1; ++j) {
                if (events[j].y >= mid) break;
                double nextY = min((double)events[j+1].y, mid);
                // येथे आपण आधीच काढलेली width वापरतो
                // (टीप: या भागात logic सुधारण्यासाठी आपण प्री-कॅल्क्युलेटेड एरिया वापरू शकतो)
            }
            // (Re-refining the search for absolute speed)
        }

        // --- अधिक सोपी पद्धत (Linear pass after totalArea) ---
        double cumulativeArea = 0;
        for (int i = 0; i < (int)events.size() - 1; ++i) {
            // प्रत्येक इव्हेंटनंतर ट्री अपडेट करा
            if (i > 0) update(1, 0, n - 2, events[i-1].x1, events[i-1].x2, events[i-1].type);
            else update(1, 0, n - 2, events[0].x1, events[0].x2, events[0].type); // First update manual
            
            // हा भाग थोडा किचकट आहे, सोप्या भाषेत:
            // आपण खालून वर जातोय, ज्या क्षणी cumulativeArea > target होईल, 
            // त्या interval मध्येच आपली 'ans line' आहे.
        }
        
        // अचूकतेसाठी खालील Optimized approach वापरा:
        return findPreciseY(events, n, target);
    }

    double findPreciseY(vector<Event>& events, int n, double target) {
        tree.assign(4 * n, {0, 0});
        double currentArea = 0;
        for (int i = 0; i < (int)events.size() - 1; ++i) {
            update(1, 0, n - 2, events[i].x1, events[i].x2, events[i].type);
            double dy = events[i+1].y - events[i].y;
            double width = tree[1].length;
            if (currentArea + (dy * width) >= target) {
                return events[i].y + (target - currentArea) / width;
            }
            currentArea += dy * width;
        }
        return events.back().y;
    }
};