package main

func main() {
	// day1()
	// day1by2()
	// day2()
	// fmt.Println(day2by2())
	// day3()
	// day4()
	// day4by2()
	// day5()
	day5by2()
}

// For Part 1, I sorted and merged all intervals, then used binary search on the merged list to determine whether the ingredient is fresh. This yields a time complexity of O(N log N) for sorting plus O(log N) per query (after merging).

// For Part 2, I only perform the sorting and merging, then compute the total covered time by summing (end − start + 1) for each merged interval.
