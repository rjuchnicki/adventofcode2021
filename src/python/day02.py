def part1(commands):
    horizontal = 0
    depth = 0
    for dir, dist in commands:
        if dir == 'forward':
            horizontal += dist
        elif dir == 'down':
            depth += dist
        elif dir == 'up':
            depth -= dist

    return (horizontal, depth)

def part2(commands):
    horizontal = 0
    depth = 0
    aim = 0
    for dir, delta in commands:
        if dir == 'forward':
            horizontal += delta
            depth += aim * delta
        elif dir == 'down':
            aim += delta
        elif dir == 'up':
            aim -= delta

    return (horizontal, depth)

def main():
    with open('../../data/day02.txt') as f:
        commands = [command.strip().split(' ') for command in f.readlines()]
        commands = [(command[0], int(command[1])) for command in commands]

    horizontal, depth = part1(commands)
    print(horizontal * depth)
    horizontal, depth = part2(commands)
    print(horizontal * depth)


if __name__ == '__main__':
    main()
    