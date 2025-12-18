package main

import (
	"fmt"
	"strconv"
	"strings"
)

func day6() {
	//noob approach
	content := take("../input/input6.txt")
	myArr := strings.Split(content, "\n")
	fmt.Println(myArr)

	twoD := make([][]string, len(myArr))
	for i, v := range myArr {
		twoD[i] = strings.Fields(v) // i do not require empty space to be added
	}
	fmt.Println(twoD)

	total := 0

	for i := 0; i < len(twoD[0]); i++ {
		curr := 0
		xcurr := 1
		symbol := twoD[len(twoD)-1][i]
		for j := 0; j < len(twoD)-1; j++ {
			num, _ := strconv.Atoi(twoD[j][i])
			if symbol == "+" {
				curr += num
			}
			if symbol == "*" {
				xcurr *= num
			}
		}
		if symbol == "+" {
			total += curr
		}
		if symbol == "*" {
			total += xcurr
		}
	}
	fmt.Println(total)
}
