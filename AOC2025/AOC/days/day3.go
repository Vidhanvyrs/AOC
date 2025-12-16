package main

import (
	"fmt"
	"math"
	"strings"
)

func day3() {
	content := take("../input/input3.txt")
	// content = strings.ReplaceAll(content, "\n", "")
	myArr := strings.Split(content, "\n")
	fmt.Println(myArr)

	total := 0

	for i := 0; i < len(myArr); i++ {
		str := myArr[i]
		max := 0
		maxIdx := 0
		for j := 0; j < len(str)-1; j++ {
			curr := int(str[j] - '0')
			if curr > max {
				max = curr
				maxIdx = j
			}
		}
		secondmax := 0
		for j := maxIdx + 1; j < len(str); j++ {
			curr := int(str[j] - '0')
			secondmax = int(math.Max(float64(secondmax), float64(curr)))
		}
		total += (max * 10) + secondmax

	}
	fmt.Println(total)
}
