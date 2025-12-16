package main

import (
	"fmt"
	"strings"
)

func day4() {
	content := take("../input/input4.txt")
	// content = strings.ReplaceAll(content, "\n", "")
	myArr := strings.Split(content, "\n")
	fmt.Println(myArr)

	rows := len(myArr)
	cols := len(myArr[0])
	fmt.Println(rows, cols)

	matrix := make([][]string, rows)
	for i := 0; i < rows; i++ {
		matrix[i] = make([]string, cols)
		for j := 0; j < cols; j++ {
			ch := string(myArr[i][j])
			matrix[i][j] = ch
		}
	}
	fmt.Println(matrix)

	for i := 0; i < cols; i++ {
		for j := 0; j < rows; j++ {
			if matrix[i][j] == "." {
				continue
			} else {
				if directionMove(i, j, matrix) {
					matrix[i][j] = "x"
				}
			}
		}

	}

	ans := 0
	for i := 0; i < cols; i++ {
		for j := 0; j < rows; j++ {
			if matrix[i][j] == "x" {
				ans++
			}
		}
	}

	fmt.Print(ans)

}

func directionMove(row int, col int, matrix [][]string) bool {
	drow := []int{-1, -1, -1, 0, 0, 1, 1, 1}
	dcol := []int{-1, 0, 1, -1, 1, -1, 0, 1}
	count := 0

	for i := 0; i < len(drow); i++ {
		nrow := row + drow[i]
		ncol := col + dcol[i]
		if nrow >= 0 && nrow < len(matrix) && ncol >= 0 && ncol < len(matrix[0]) {
			if matrix[nrow][ncol] == "@" || matrix[nrow][ncol] == "x" {
				count++
			}
		}
	}
	return count < 4
}

func day4by2() {
	content := take("../input/input4.txt")
	// content = strings.ReplaceAll(content, "\n", "")
	myArr := strings.Split(content, "\n")
	fmt.Println(myArr)

	rows := len(myArr)
	cols := len(myArr[0])
	fmt.Println(rows, cols)

	matrix := make([][]string, rows)
	for i := 0; i < rows; i++ {
		matrix[i] = make([]string, cols)
		for j := 0; j < cols; j++ {
			ch := string(myArr[i][j])
			matrix[i][j] = ch
		}
	}
	fmt.Println(matrix)

	stillPending := true
	ultimateAns := 0
	for stillPending {
		if recall(cols, rows, matrix) > 0 {
			ultimateAns += removalnCount(matrix)
		} else {
			stillPending = false
		}
	}

	fmt.Println(ultimateAns)

}

func movement(row int, col int, matrix [][]string) bool {
	drow := []int{-1, -1, -1, 0, 0, 1, 1, 1}
	dcol := []int{-1, 0, 1, -1, 1, -1, 0, 1}
	count := 0

	for i := 0; i < len(drow); i++ {
		nrow := row + drow[i]
		ncol := col + dcol[i]
		if nrow >= 0 && nrow < len(matrix) && ncol >= 0 && ncol < len(matrix[0]) {
			if matrix[nrow][ncol] == "@" {
				count++
			}
		}
	}
	return count < 4
}

func recall(cols int, rows int, matrix [][]string) int {
	for i := 0; i < cols; i++ {
		for j := 0; j < rows; j++ {
			if matrix[i][j] == "." {
				continue
			} else {
				if movement(i, j, matrix) {
					matrix[i][j] = "x"
				}
			}
		}

	}

	ans := 0
	for i := 0; i < cols; i++ {
		for j := 0; j < rows; j++ {
			if matrix[i][j] == "x" {
				ans++
			}
		}
	}
	return ans
}

func removalnCount(matrix [][]string) int {
	count := 0
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if matrix[i][j] == "x" {
				matrix[i][j] = "."
				count++
			}
		}
	}
	return count
}
