package org.mypro.study.algorithms.picture.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 网络延迟时间
 * 
 * @author hew
 *
 *         <pre>
有 n 个网络节点，标记为 1 到 n。
给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
示例 2：
输入：times = [[1,2,1]], n = 2, k = 1
输出：1
示例 3：
输入：times = [[1,2,1]], n = 2, k = 2
输出：-1
输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
输出：2
 *         </pre>
 */
public class Q743 {
	public int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, List<int[]>> graph = new HashMap<Integer, List<int[]>>();
		for (int[] time : times) {
			graph.computeIfAbsent(time[0], key -> new ArrayList<int[]>()).add(new int[] { time[1], time[2] });
		}
		//
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparing(a -> a[0]));
		pq.offer(new int[] { 0, k });
		//

		while (!pq.isEmpty()) {
			int[] cuurent = pq.poll();
			int time = cuurent[0];
			int node = cuurent[1];
			//
			if (time > dist[node]) {
				continue;
			}
			//
			if (graph.containsKey(node)) {
				for (int[] neightbor : graph.get(node)) {
					int neighborNode = neightbor[0];
					int newTime = time + neightbor[1];
					//

					//
					if (newTime < dist[neighborNode]) {
						dist[neighborNode] = newTime;
						pq.offer(new int[] { newTime, neighborNode });
					}
				}
			}
		}
		//
		int maxTime = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				return -1;
			}
			maxTime = Math.max(maxTime, dist[i]);
		}
		return maxTime;
	}
}
