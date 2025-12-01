package main

import (
	"fmt"
	"strconv"
	"strings"
)

func day1() {
	content := take("../input/input1.txt")
	myArr := strings.Split(content, "\n")
	fmt.Println(myArr)

	numArr := make([]int, len(myArr))
	for i := 0; i < len(myArr); i++ {
		currStr := myArr[i]
		currNum, err := strconv.Atoi(currStr[1:])
		if err != nil {
			fmt.Printf("Atoi Error", err)
		}
		if currStr[0] == 'L' {
			currNum = 0 - currNum
		} else {
			currNum = 0 + currNum
		}
		numArr[i] = currNum
	}

	fmt.Println(numArr)
	starting_pit := 50
	count := 0
	for i := 0; i < len(numArr); i++ {
		if numArr[i] < 0 {
			starting_pit += numArr[i]
			starting_pit = (100 + starting_pit) % 100
			if starting_pit == 0 {
				count++
			}
		}
		if numArr[i] > 0 {
			starting_pit += numArr[i]
			starting_pit = starting_pit % 100
			if starting_pit == 0 {
				count++
			}
		}
	}
	fmt.Println(count)
}

func day1by2() {
	content := take("../input/input1.txt")
	myArr := strings.Split(content, "\n")
	fmt.Println("IN 1by2", myArr)

	numArr := make([]int, len(myArr))
	for i := 0; i < len(myArr); i++ {
		currStr := myArr[i]
		currNum, err := strconv.Atoi(currStr[1:])
		if err != nil {
			fmt.Printf("Atoi Error", err)
		}
		if currStr[0] == 'L' {
			currNum = 0 - currNum
		} else {
			currNum = 0 + currNum
		}
		numArr[i] = currNum
	}

	fmt.Println(numArr)
	starting_pit := 50
	count := 0
	for i := 0; i < len(numArr); i++ {
		if numArr[i] < 0 {
			myNum := 0 - numArr[i]
			for range myNum {
				if starting_pit == 0 {
					count++
					fmt.Println("NEGC", count)
				}
				starting_pit = (starting_pit - 1 + 100) % 100
				fmt.Println("NEG", starting_pit)
			}
		} else if numArr[i] > 0 {
			for j := 0; j < numArr[i]; j++ {
				if starting_pit == 0 {
					count++
					fmt.Println("POSC", count)
				}
				starting_pit = (starting_pit + 1) % 100
				fmt.Println("POS", starting_pit)
			}
		}
	}
	fmt.Println(count)
}
