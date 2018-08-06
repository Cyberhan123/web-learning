sass_dir     =  "sass"
css_dir      =  "css"
environment  = :development
output_style = (environment == :production) ? :compressed : :expanded
Encoding.default_external = Encoding.find('utf-8') #支持中文注释
line_comments = false #去掉行注释