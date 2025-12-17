package main

import (
	"fmt"
	"strconv"
	"strings"
)

func day5() {
	//noob approach
	content := take("../input/input5.txt")
	myArr := strings.Split(content, "\n\n")
	ranges := strings.Split(myArr[0], "\n")
	ingredients := strings.Split(myArr[1], "\n")
	fmt.Println(ranges)
	fmt.Println(ingredients)

	count := 0
	for init := 0; init < len(ingredients); init++ {
		myIngredient, _ := strconv.Atoi(ingredients[init])
		flag := false
		for i := 0; i < len(ranges); i++ {
			rangeParts := strings.Split(ranges[i], "-")
			start, _ := strconv.Atoi(rangeParts[0])
			end, _ := strconv.Atoi(rangeParts[1])
			if myIngredient >= start && myIngredient <= end {
				flag = true
				break
			}
		}
		if flag {
			count++
		}
	}
	fmt.Println(count)
}

func day5by2() {
	content := take("../input/input5.txt")
	myArr := strings.Split(content, "\n\n")
	ranges := strings.Split(myArr[0], "\n")
	fmt.Println(ranges)

	Pair := make([][]int, len(ranges))
	for i := 0; i < len(ranges); i++ {
		inside := make([]int, 2)
		rangeParts := strings.Split(ranges[i], "-")
		start, _ := strconv.Atoi(rangeParts[0])
		end, _ := strconv.Atoi(rangeParts[1])
		inside[0] = start
		inside[1] = end
		Pair[i] = inside
	}
	fmt.Println(Pair)
	for i := 0; i < len(Pair)-1; i++ {
		swapped := false
		for j := 0; j < len(Pair)-i-1; j++ {
			if Pair[j][0] > Pair[j+1][0] {
				temp := Pair[j]
				Pair[j] = Pair[j+1]
				Pair[j+1] = temp
				swapped = true
			}
		}
		if swapped == false {
			break
		}

	}
	fmt.Println("sorted\n", Pair)
	newArr := Pair
	for i := 0; i < len(newArr)-1; {
		if newArr[i][1] >= newArr[i+1][0] {
			if newArr[i+1][1] > newArr[i][1] {
				newArr[i][1] = newArr[i+1][1]
			}
			newArr = append(newArr[:i+1], newArr[i+2:]...)
		} else {
			i++
		}
	}
	fmt.Println("merged\n", newArr)

	total := 0
	for i := 0; i < len(newArr); i++ {
		total += newArr[i][1] - newArr[i][0] + 1
	}

	fmt.Println(total)

}
