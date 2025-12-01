package main

import (
	"fmt"
	"os"
)

func take(filepath string) string {
	content, err := os.ReadFile(filepath)
	if err != nil {
		fmt.Println("Error", err)
		return ""
	}
	filecontentString := string(content)
	return filecontentString
}
