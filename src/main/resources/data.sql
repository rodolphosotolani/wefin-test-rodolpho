INSERT INTO public.usuario(email, nome, password, username)
VALUES ('admin@wefin.com.br', 'Administrador', '$2y$12$44KPHViErMC0s5oWLxtOCeV6jzbkBVLaX5rcGfsoS7V41cRnSdgTe', 'admin')
ON CONFLICT (username) DO NOTHING;
