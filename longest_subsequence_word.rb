def longest_subsequence_word_bad(s, d)
  output_strings = Array.new(d.size)

  d.each_with_index do |text, index|
    output_strings[index] ||= ''
    s.split('').each do |s_char|
      if text[0] == s_char
        output_strings[index] += s_char
        text = text[1..-1]
      end
    end
  end

  output_strings.sort_by(&:length)
  output_strings.reverse!
  output_strings[0]
end

# more optimal version
def longest_subsequence_word_good(letters, words)
  words = words.sort_by(&:length)
  words.reverse!

  letter_positions = {}
  letters.split('').each_with_index do |letter, index|
    letter_positions[letter.to_sym] ||= []
    letter_positions[letter.to_sym] << index
  end

  words.each do |word|
    pos = 0

    word.split('').each_with_index do |w_letter, w_index|
      break if letter_positions[word.to_sym].present?

      possible_positions = []
      letter_positions[w_letter.to_sym].each do |p|
        possible_positions << p if p >= pos
      end

      break if possible_positions.empty?
      pos = possible_positions[0] + 1

      return word if w_index == (word.size - 1)
    end
  end
end
