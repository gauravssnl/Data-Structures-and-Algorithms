def rec_lcs(s1, s2):
    if s1 == "" or s2 == "":
        return ""
    if s1[-1] == s2[-1]:
        return rec_lcs(s1[:-1], s2[:-1]) + s1[-1]
    else:
        return max(rec_lcs(s1[:-1], s2), rec_lcs(s1, s2[:-1]), key=len)


if __name__ == "__main__":
    print(rec_lcs("abcdefghzxfgh", "cabdefghrst"))
