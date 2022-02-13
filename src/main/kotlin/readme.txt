You need to perform such actions (for example, you want to hide message "hello"):
0. Add marker to the end of message:
"hello\u0000\u0000\u0003"
1. Encode message to bytes:
hello = [104, 101, 108, 108, 111, 0, 0, 3]
2. Covert bytes to binary:
['1101000', '1100101', '1101100', '1101100', '1101111', '0', '0', '11']
3. Pad bytes with leading zeroes:
['01101000', '01100101', '01101100', '01101100', '01101111', '00000000', '00000000', '00000011']
4. Join bytes to bit array:
[0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1]
5. Write these bits to blue channel: image.setRGB(x, y, Color(r, g, b.and(254).or(bit) % 256).rgb)