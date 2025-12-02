package main

import (
	"fmt"
	"strconv"
	"strings"
)

func day2() int {
	content := take("../input/example2.txt")
	content = strings.ReplaceAll(content, "\n", "")
	myArr := strings.Split(content, ",")
	fmt.Println(myArr)
	sum := 0
	for i := 0; i < len(myArr); i++ {
		curr := strings.TrimSpace(myArr[i])
		if curr == "" {
			continue
		}
		split_range := strings.Split(curr, "-")
		if len(split_range) != 2 {
			fmt.Println("Invalid range format:", curr)
			continue
		}
		start, err := strconv.Atoi(strings.TrimSpace(split_range[0]))
		if err != nil {
			fmt.Println("Error parsing start:", err)
			continue
		}
		end, err1 := strconv.Atoi(strings.TrimSpace(split_range[1]))
		if err1 != nil {
			fmt.Println("Error parsing end:", err1)
			continue
		}
		for start <= end {
			if len(strconv.Itoa(start))%2 == 0 {
				if divide(start) {
					fmt.Println("NUM", start)
					sum += start
				}
			}
			start += 1
		}
	}
	return sum
}

func divide(num int) bool {
	str := strconv.Itoa(num)
	size := len(str)
	for i := 0; i < size/2; i++ {
		if str[i] != str[size/2+i] {
			return false
		}
	}
	return true
}

func day2by2() int {
	content := take("../input/input2.txt")
	content = strings.ReplaceAll(content, "\n", "")
	myArr := strings.Split(content, ",")
	fmt.Println(myArr)
	sum := 0
	for i := 0; i < len(myArr); i++ {
		curr := strings.TrimSpace(myArr[i])
		if curr == "" {
			continue
		}
		split_range := strings.Split(curr, "-")
		if len(split_range) != 2 {
			fmt.Println("Invalid range format:", curr)
			continue
		}
		start, err := strconv.Atoi(strings.TrimSpace(split_range[0]))
		if err != nil {
			fmt.Println("Error parsing start:", err)
			continue
		}
		end, err1 := strconv.Atoi(strings.TrimSpace(split_range[1]))
		if err1 != nil {
			fmt.Println("Error parsing end:", err1)
			continue
		}
		for start <= end {
			if atleasttwo(start) {
				fmt.Println("NUM", start)
				sum += start
			}
			start += 1
		}
	}
	return sum
}

func atleasttwo(num int) bool {
	str := strconv.Itoa(num)
	size := len(str)

	eachSame := true
	for i := 1; i < size; i++ {
		if str[i] != str[0] {
			eachSame = false
			break
		}
	}
	if eachSame && size >= 2 {
		return true
	}

	// saari slices check karege
	for currsize := 1; currsize <= size/2; currsize++ {
		// sirf tabhi check karege jab string evenly divide ho rha hai currsize se
		if size%currsize != 0 {
			continue
		}

		var slices []string
		for i := 0; i < size; i += currsize {
			slices = append(slices, str[i:i+currsize])
		}

		same := true
		for i := 1; i < len(slices); i++ {
			if slices[i] != slices[0] {
				same = false
				break
			}

		}
		if same && len(slices) >= 2 {
			return true
		}
	}
	return false
}
