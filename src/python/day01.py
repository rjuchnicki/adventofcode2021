def part1(depths):
    increases = 0
    for i in range(1, len(depths)):
        if depths[i] > depths[i-1]:
            increases += 1

    return increases

def part2(depths):
    increases = 0
    for i in range(3, len(depths)):
        # Compare the first and last elements of each group of 4 adjacent
        # elements since the two sums for a sliding window of 3 will share the
        # middle 2 elements.
        if depths[i-3] < depths[i]:
            increases += 1

    return increases

def main():
    with open('../../data/day01.txt') as f:
        depths = [int(depth.strip()) for depth in f.readlines()]

    print(part1(depths))
    print(part2(depths))


if __name__ == '__main__':
    main()
