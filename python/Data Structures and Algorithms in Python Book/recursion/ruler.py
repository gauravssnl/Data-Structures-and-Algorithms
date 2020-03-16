def draw_line(tick_length, tick_label=''):
    line = '-' * tick_length
    if tick_label:
        line += tick_label
    print(line)

def draw_interval(center_tick_length):
    if center_tick_length > 0:
        draw_interval(center_tick_length-1)
        draw_line(center_tick_length)
        draw_interval(center_tick_length-1)

def draw_ruler(num_inches, major_tick_length):
    draw_line(major_tick_length, '0') # draw '0' line

    for j in range(1, num_inches + 1):
        draw_interval(major_tick_length - 1)
        draw_line(major_tick_length, str(j))

if __name__ == "__main__":
    num_inches = 2
    major_tick_length = 4
    draw_ruler(num_inches, major_tick_length)